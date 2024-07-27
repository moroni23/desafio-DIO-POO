public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        if (!this.conteudosInscritos.isEmpty()) {
            Conteudo conteudo = this.conteudosInscritos.iterator().next();
            this.conteudosConcluidos.add(conteudo);
            this.conteudosInscritos.remove(conteudo);
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    // Métodos de acesso e modificação aqui...

    @Override
    public boolean equals(Object o) {
        // Implementação do equals...
    }

    @Override
    public int hashCode() {
        // Implementação do hashCode...
    }

    public String getConteudosInscritos() {
    }
}
